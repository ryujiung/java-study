package prob3;

public class Duck extends Bird {
    public Duck(String name) {
        super.setName(name);
    }

    public Duck() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void fly() {
        System.out.println("오리("+getName() +")"+ "가 날아다닙니다.");
    }

    @Override
    public void sing() {
        System.out.println("오리("+getName() +")"+ "가  소리내어 웁니다.");
    }
    public String toString() {
        return "오리("+name +")"+ "의 이름은 " + name + " 입니다.";
    }
}
