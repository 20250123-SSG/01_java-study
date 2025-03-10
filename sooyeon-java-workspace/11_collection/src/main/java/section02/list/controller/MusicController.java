package section02.list.controller;

import section02.list.dto.Music;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public int editMusic(String title, String artist, String editTitle) {
        int result = 0;
        for (Music m : musics) {
            if (m.getTitle().equals(title) && m.getArtist().equals(artist)) {
                m.setTitle(editTitle);
                result++;
                break;
            }
        }
        return result;
    }

    public List<Music> findMusicByTitle(String keyword) {
        List<Music> result = new ArrayList<>();
        for (Music m : musics) {
            if (m.getTitle().contains(keyword)) {
                result.add(m);
            }
        }
        return result;
    }

    public List<Music> findMusicByArtist(String artist) {
        List<Music> result = new ArrayList<>();

        for (Music m : musics) {
            if (m.getArtist().contains(artist)) {
                result.add(m);
            }
        }
//        return musics.stream()
//                .filter(m -> m.getArtist().contains(artist))
//                .collect(Collectors.toList());
        return result;
    }

    public int findMusicCount(String title) {
        int count = 0;

        for (Music m : musics) {
            if (m.getTitle().contains(title)) {
                count++;
            }
        }
//       count += (int) musics.stream()
//                .filter((m) -> m.getTitle().equals(title))
//                .count();
        return count;
    }

    public List<Music> sortMusic(int sortType) {
        /**
         * Collections.sort(리스트) : 클래스에 정의된 compareTo를 기준으로 정렬,원본 객체가 정렬됨
         * Collections.sort(리스크,Comparator객체) : 따로 생성한 Comparator객체를 넘겨 정렬, 외부에서 다양한 정렬 기준을 넘김
         * 리스트.sort(Comparator객체) : 위와 동작 방식은 똑같음. 더 최신
         */
        List<Music> copy = new ArrayList<>(musics);

        if (sortType == 1 || sortType == 2) {
//            copy.sort(new Comparator<Music>() {
//                @Override
//                public int compare(Music o1, Music o2) {
//                    return o1.getTitle().compareTo(o2.getTitle());
//                }
//            });
            copy.sort(Comparator.comparing(Music::getTitle));
        } else if (sortType == 3 || sortType == 4) { //else if 로해야 효율적
            copy.sort(Comparator.comparing(Music::getArtist));
        }

        if (sortType == 2 || sortType == 4) {
            Collections.reverse(copy);
        }

        return copy;
    }

}

