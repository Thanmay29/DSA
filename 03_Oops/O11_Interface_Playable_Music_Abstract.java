package Oops;

//Abstract
//
//Define an interface Playable with a method play().
// Implement it in MusicPlayer, VideoPlayer.
//

interface O11_Interface_Playable_Music_Abstract {
    void play();
}

class MusicPlayer implements O11_Interface_Playable_Music_Abstract{
    public void play(){
        System.out.println("Playing Music");
    }

    public static void main(String[] args) {

        //Music Player
        O11_Interface_Playable_Music_Abstract mp = new MusicPlayer();
        mp.play();

        //Video Player
        O11_Interface_Playable_Music_Abstract vp = new VideoPlayer();
        vp.play();
    }
}

class VideoPlayer implements O11_Interface_Playable_Music_Abstract{
    public void play(){
        System.out.println("Playing video");
    }
}
