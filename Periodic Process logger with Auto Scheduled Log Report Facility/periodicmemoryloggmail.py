import os
import time
import psutil
import smtplib
import schedule
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.mime.base import MIMEBase
from email import encoders
from urllib import request

def is_connected():
    try:
        urllib.request.urlopen('http://216.58.192.142', timeout=1)
        return True
    except Exception as err:
        return False

def send_email(log_file):
    try:
        fromaddr = "omgawali777@gmail.com"
        toaddr = "omgawali777@gmail.com"
        password = "xxxxxxc"

        msg = MIMEMultipart()
        msg['From'] = fromaddr
        msg['To'] = toaddr
        msg['Subject'] = "Process Log"

        body = """
        HELLO
        This MAIL is Auto Generated
        """

        msg.attach(MIMEText(body, 'plain'))

        # Attach the log file
        with open(log_file, "rb") as file:
            part = MIMEBase('application', 'octet-stream')
            part.set_payload(file.read())
            encoders.encode_base64(part)
            part.add_header('Content-Disposition', f"attachment; filename={os.path.basename(log_file)}")
            msg.attach(part)

        s = smtplib.SMTP('smtp.gmail.com', 587)
        s.starttls()

        s.login(fromaddr, password)

        s.sendmail(fromaddr, toaddr, msg.as_string())

        s.quit()

        print("Log File sent")

    except Exception as E:
        print("Unable to send", E)

def process_log(log_dir="Marvellous"):
    listprocess = []

    if not os.path.exists(log_dir):
        try:
            os.mkdir(log_dir)
        except:
            pass

    separator = "-" * 80
    log_path = os.path.join(log_dir, f"MarvellousLog{time.time()}.log")

    with open(log_path, 'w') as f:
        f.write(separator + "\n")
        f.write("Marvellous Infosystem Process Logger:" + time.ctime() + "\n")
        f.write(separator + "\n")

        for proc in psutil.process_iter():
            try:
                pinfo = proc.as_dict(attrs=['pid', 'name', 'username'])
                vms = proc.memory_info().vms / (1024 * 1024)
                pinfo['vms'] = vms
                listprocess.append(pinfo)

            except (psutil.NoSuchProcess, psutil.AccessDenied, psutil.ZombieProcess):
                pass

        for element in listprocess:
            f.write(f"{element}\n")

        print("Logfile successfully generated at", log_path)

    # Send the log file via email
    send_email(log_path)

def main(interval_minutes=1):
    schedule.every(interval_minutes).minutes.do(process_log)

    while True:
        schedule.run_pending()
        time.sleep(1)

if __name__ == "__main__":
    main()
