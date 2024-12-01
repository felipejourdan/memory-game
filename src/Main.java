public class Main {
    public static void main(String[] args) {

        /*Card card1 = new Card(20, 20, 50);
        Card card2 = new Card(80,20,50);*/
        Board board = new Board(5, 4, 50);

        MyMouse mymouse = new MyMouse();
        mymouse.setCard(Card);
        mymouse.init();

        
    }
}