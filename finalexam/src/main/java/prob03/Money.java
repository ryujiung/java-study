package prob03;

public class Money {
	private int amount;
	
	/* 코드 작성 */
	
	public Money(int amount) {
		this.amount =  amount;
	}


	public Object add(Money money) {
		Money a = new Money(this.amount+money.amount);
		return a;
	}

	public Object minus(Money money) {
		Money a = new Money(this.amount - money.amount);
		return a;
	}

	public Object multiply(Money money) {
		Money a = new Money(this.amount*money.amount);
		return a;
	}

	public Object devide(Money money) {
		Money a = new Money(this.amount/money.amount);
		return a;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Money) {
			return ((Money) obj).amount == this.amount;
		}
		return false;
		
		
	}
	
}
