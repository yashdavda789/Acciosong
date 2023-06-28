import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1=new Album("Butta Bonna","Arman malik");
        Album album2=new Album("Doorie","Atif Asian");

        album1.addSong("Butta Bonna",4.3);
        album1.addSong("Srivali",3.2);

        album2.addSong("Doorie",3.1);
        album2.addSong("Kuch is Tarah",4.2);
        album2.addSong("Mahi Ve",4);
        album2.addSong("Mahi Ve",4);
        //find song
        if(album1.findSong("abc")){
            System.out.println("abc is present");
        }
        else{
            System.out.println("abc is not present");
        }
        if(album2.findSong("Doorie")){
            System.out.println("Doorie is present");
        }
        else {
            System.out.println("Doorie is not present");
        }
        //create playlist
        LinkedList<Song> myPlayList=new LinkedList<>();
        album1.addToPlayListFromAlbum("srivali",myPlayList);
        album2.addToPlayListFromAlbum(2,myPlayList);
        album1.addToPlayListFromAlbum(1,myPlayList);

        //wrong song
        album1.addToPlayListFromAlbum(5,myPlayList);
        album2.addToPlayListFromAlbum("random",myPlayList);

   play(myPlayList);
    }
    public static void play(LinkedList<Song>playList){
        ListIterator<Song> itr=playList.listIterator();
         //if list is empty
        if(!itr.hasNext()){
            System.out.println("your playlist is empty");
            return;
        }
        System.out.println("Now playing :");
        System.out.println(itr.next());
        printMenu();
        Scanner sc = new Scanner(System.in);
         boolean quit=false;
        while(true){
            System.out.println("please enter the option");
            int option=sc.nextInt();
            switch(option){
                case 1:
                    if(itr.hasNext()){
                        System.out.println("now playing");
                        System.out.println(itr.next());
                    }else{
                        System.out.println("you have reached the end of playlist");
                    }
                break;
                case 2:
                    if(itr.hasPrevious()){
                        System.out.println("now playing");
                        System.out.println(itr.previous());
                    }else{
                        System.out.println("you have reached the start of playlist");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    printSongs(playList);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    exit(0);

            }
        }
    }

    private static void exit(int i) {
    }

    public static void printSongs(LinkedList<Song>playList){
        for(Song s:playList){
            System.out.println(s);
        }
        return;
    }
    public static void printMenu(){
        System.out.println("1.play next song");
        System.out.println("2.play previous song");
        System.out.println("3.repeat the current song");
        System.out.println("4.show all songs in playlist");
        System.out.println("5.delete the current song");
        System.out.println("6.show the menu again");
        System.out.println("exit");
    }

}