package section02.list.controller;

import section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicController {
    private List<Music> musics = new ArrayList<>();

    {
        musics.add(new Music("a", "b"));
        musics.add(new Music("b", "c"));
        musics.add(new Music("d", "e"));
    }

    public boolean insertMusic(String title, String artist) {
        return musics.add(new Music(title, artist));
    }

    public List<Music> selectMusicList() {
        return musics;
    }

    public int removeMusic(String title) {
//        List<Music> removeMusics = new ArrayList<>();
//        for(Music music : musics) {
//            if(music.getTitle().equals(title)) {
//                removeMusics.add(music);
//            }
//        }
//        if(removeMusics.isEmpty()) {
//            return false;
//        }
//        for(Music music : removeMusics) {
//            musics.remove(music);
//        }
//        return true;

        int result = 0;
        // Music removeMusic = null;


        /*
        for(Music music : musics) {
            if(music.getTitle().equals(title)) {
                musics.remove(music);
                result++;
                break; //얘가 없으면 예외
            }
        }

         */


        /**
         * 근데 왜 예외가 안되지 위에는 Break가 없으면 예외가 터지는데
         * 인덱스 for문으로하면 인덱스로 삭제하나, 객체를 꺼내와서 삭제를 하나 잘 작동된다.
         */
        for (int i = 0; i < musics.size(); i++) {
            if (musics.get(i).getTitle().equals(title)) {
                musics.remove(musics.get(i));
               // musics.remove(i);
                result++;
            }
        }



        return result;
    }

    public int editMusic(String title, String artist,String editTitle) {
        int result = 0;
        for(Music m : musics) {
            if(m.getTitle().equals(title) && m.getArtist().equals(artist)) {
                m.setTitle(editTitle);
                result++;
                break;
            }
        }
        return result;
    }
}

