## Entities

1. Traffic Signal
2. Vehicle
3. Road

### Traffic Signal

currentSignal = RED | YELLOW | GREEN
setSignalColour()
getSignalColour()

### Vehicle

state = MOVING, STOPPED, IDLING
drive - fn
brake - fn
igniteEngine - fn

### Emergency Vehicle

1. Can change signal to GREEN.
2. Once emergency vehicle crosses the road revert back to RED.

### Road

Traffic Signal
Vehicle

### Given a 3d equation with variable x, y ,z we need to find values of x , y and z.

ax + by + cz = d

x + y + z = 6
2x - y + z = 3
x + 2y - 3z = -4

Develop a solution for this equation using kramers rule

1. Exactly one solution
2. Two solutions
3. No solutions

*
    - Representation of equation should be decoupled from the algorithm that solves it.
### Entities
1. Equation
2. Solution

### Given an input date range and the date of fiscal year close month, split this date range into n number of fiscal years along with the actual date ranges

### Entities
1. Fiscal Year 
2. DateRange
3. YearSplitter

### Year
1. yearStart
2. yearEnd

### Fiscal Year
1. FY 2025 = 31st March 2025 - 31st March 2026

### Date Range
1. startDate
2. endDate
3. Range is valid when start date is less than end date

### YearSplitter
1. Splits the given range into resulting start, end dates for the years within the range.

