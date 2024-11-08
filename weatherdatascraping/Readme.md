# Weather Data Scraping Project

This project is designed to scrape daily weather data from [Estes Park Weather Archive](http://www.estesparkweather.net/archive_reports.php?date=200901) for dates ranging from January 1, 2009, to October 28, 2018. The collected data includes various weather attributes, which are saved into a structured `pandas` DataFrame.

## Project Objectives

1. **Scrape Weather Data**:
   - Collect daily weather details for each day within the specified date range.
   - Exclude any days where data is unavailable.

2. **Data Storage in DataFrame**:
   - Store all gathered data in a `pandas` DataFrame with each row representing the weather details of a given day.
   - Ensure the data is formatted and cleaned for analysis.

## DataFrame Details

### Expected Columns

The DataFrame will contain the following columns (order does not matter):

#### Average Daily Values
- **Average temperature (°F)**
- **Average humidity (%)**
- **Average dewpoint (°F)**
- **Average barometer (in)**
- **Average windspeed (mph)**
- **Average gustspeed (mph)**
- **Average direction (°deg)**
- **Rainfall for month (in)**
- **Rainfall for year (in)**
- **Maximum rain per minute**

#### Extreme Daily Values
- **Maximum temperature (°F)**
- **Minimum temperature (°F)**
- **Maximum humidity (%)**
- **Minimum humidity (%)**
- **Maximum pressure**
- **Minimum pressure**
- **Maximum windspeed (mph)**
- **Maximum gust speed (mph)**
- **Maximum heat index (°F)**

### Additional Details

- Each record in the DataFrame represents a specific day’s weather summary.
- The index column is in date-time format (`yyyy-mm-dd`) for easy time-based analysis.
- All columns are cleaned and converted to appropriate data types to ensure the data is ready for analysis.
