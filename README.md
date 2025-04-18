# Mortgage Calculator

A simple Java-based mortgage calculator that takes user input to compute monthly mortgage payments and displays a full payment schedule.

## Features

- Input prompts for:
  - Home value
  - Down payment
  - Annual interest rate
  - Loan period (in years)
- Calculates:
  - Monthly mortgage payments
  - Remaining balance after each monthly payment
- Displays:
  - Formatted monthly payment summary
  - Full amortization schedule

## Usage

1. Compile the code:

   ```bash
   javac Main.java
   ```

2. Run the program:

   ```bash
   java Main
   ```

3. Follow the prompts:

   - Enter the **home value** between `$1,000` and `$1,000,000`
   - Enter a **down payment**
   - Enter the **annual interest rate** (0% - 30%)
   - Enter the **loan period** in years (1 - 30)

   Example:
   ```
   Home Value ($1K - $1M): $500000
   Down Payment Amount: $100000
   Annual Interest Rate (%): 5
   Period (Years): 30
   ```

   The program will print:

   - Monthly mortgage payment
   - A payment schedule showing remaining balance each month

## Example Output

```
MORTGAGE
--------
Monthly Payments: $2,147.29

PAYMENT SCHEDULE
----------------
$400,000.00
$399,518.38
$399,033.06
...
```

## Requirements

- Java 8 or above

## License

This project is open-source and free to use.

## Author

Created by Andrew Paynter
