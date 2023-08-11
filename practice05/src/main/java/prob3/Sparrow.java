package prob3;

public class Sparrow extends Bird {
    public Sparrow(String name) {
        super.setName(name);
    }

    public Sparrow() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void fly() {
        System.out.println("참새("+getName() +")"+ "가 날아다닙니다.");
    }

    @Override
    public void sing() {
        System.out.println("참새("+getName() +")"+ "가  소리내어 웁니다.");
    }
    public String toString() {
        return "참새("+name +")"+ "의 이름은 " + name + " 입니다.";
    }
}
