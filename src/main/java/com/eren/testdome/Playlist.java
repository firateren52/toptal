package com.eren.testdome;

import java.util.HashSet;
import java.util.Set;

// https://www.testdome.com/questions/java/playlist/21582?visibility=1&skillId=4&orderBy=Difficulty
public class Playlist {
    public static class Song {
        private String name;
        private Song nextSong;

        public Song(String name) {
            this.name = name;
        }
    
        public void setNextSong(Song nextSong) {
            this.nextSong = nextSong;
        }

        public Song getNextSong() {
            return nextSong;
        }

        // https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/ solution
        public boolean isRepeatingPlaylist() {
            Set<Song> songs = new HashSet<>();
            Song next = getNextSong();
            while(true) {
                if(next == null) {
                    return false;
                } else if(songs.contains(next)) {
                    return true;
                } else {
                    songs.add(next);
                    next = next.getNextSong();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("Eye of the tiger");
    
        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(null);
    
        System.out.println(first.isRepeatingPlaylist());
    }
}