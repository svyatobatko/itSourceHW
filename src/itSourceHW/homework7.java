package itSourceHW;

import java.util.Date;

public class homework7 {
	public static void main(String[] args) {
		Date date = new Date();

		Account account1 = new Account();
		account1.withdrawal.setAmount(100);
		account1.withdrawal.setDateWithdrawal(date.toString());
		account1.payments.setAmount(10);
		account1.payments.setDatePayments(date.toString());
		account1.receipts.setAmount(1000);
		account1.receipts.setDateReceipts(date.toString());
		
	}
}

class Account {
	Withdrawal withdrawal = new Withdrawal();
	Payments payments = new Payments();
	Receipts receipts = new Receipts();
	class Withdrawal {
		private String dateWithdrawal;
		private int amount;
		
		public String getDateWithdrawal() {
			return dateWithdrawal;
		}
		public void setDateWithdrawal(String dateWithdrawal) {
			this.dateWithdrawal = dateWithdrawal;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
	}
	class Receipts {
		private String dateReceipts;
		private int amount;
		
		public String getDateReceipts() {
			return dateReceipts;
		}
		public void setDateReceipts(String dateReceipts) {
			this.dateReceipts = dateReceipts;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
	
	}
	class Payments {
		private String datePayments;
		private int amount;
		
		public String getDatePayments() {
			return datePayments;
		}
		public void setDatePayments(String datePayments) {
			this.datePayments = datePayments;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
	
	}
}