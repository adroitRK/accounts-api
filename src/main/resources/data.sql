insert into accounts
		(account_number, account_name, account_type, account_user, currency) 
values 	
		(123456, 'SGSavings552', 'Savings', 'user001', 'SGD'),
		(123665, 'AUSavings163', 'Savings', 'user001', 'AUD'),
		(123700, 'USCurrent800', 'Current', 'user001', 'USD'),

		(253700, 'AUSavings411', 'Savings', 'user002', 'AUD'),
		(253880, 'USCurrent963', 'Current', 'user002', 'USD');

insert into transactions
		(account_number, value_date, debit_amount, credit_amount, transaction_type, transaction_narrative)
values
		(123456, '2020-10-26', 0, 2000.50, 'Credit', 'Income'),
		(123456, '2020-11-26', 0, 8850.70, 'Credit', 'Income'),
		(123456, '2020-12-26', 5210.00, 0, 'Debit', 'Entertainament'),
		(123456, '2021-01-26', 0, 1010.80, 'Credit', 'Rent Income'),

		(123665, '2020-05-05', 0, 6500.50, 'Credit', 'Income'),
		(123665, '2020-06-22', 850.70, 0, 'Debit', 'Groceries'),
		(123665, '2020-09-14', 5265.30, 0, 'Debit', 'Loan Installment'),
		(123665, '2021-01-05', 0, 2210.90, 'Credit', 'Rent Income'),

		(123700, '2020-03-01', 0, 12000.50, 'Credit', 'Salary'),
		(123700, '2020-08-22', 250.70, 0, 'Debit', 'Bills'),
		(123700, '2020-12-31', 4100.00, 0, 'Debit', 'Rent'),
		(123700, '2021-01-02', 610.80, 0, 'Debit', 'Transport'),

		(253700, '2020-10-26', 0, 200.50, 'Credit', 'Rent Income'),
		(253700, '2020-11-26', 0, 50.70, 'Credit', 'Income'),
		(253700, '2020-12-26', 0, 510.00, 'Credit', 'Income'),
		(253700, '2021-01-26', 0, 1010.80, 'Credit', 'Tax return'),

		(253880, '2020-07-11', 0, 3200.50, 'Credit', 'Income'),
		(253880, '2020-08-13', 0, 9550.70, 'Credit', 'Rent Income'),
		(253880, '2020-10-23', 1210.00, 0, 'Debit', 'Bills'),
		(253880, '2021-01-06', 710.80, 0, 'Debit', 'Groceries');