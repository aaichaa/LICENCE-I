public class MainBibli {
    public static void main(String[] args) {
        Livre lecture = new Livre();
        lecture.afficheDetails();
        Livre lire = new Livre("initiation a java","Moi",100);
        lire.afficheDetails();
       lire.setNbPages(-1);
       lire.afficheDetails();
    }
    
}
