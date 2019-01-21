package com.eren.testdome;

import java.util.*;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        Set<Friend> visited = new HashSet<>();

        return pathCount(visited, friend, 0) > 0;
    }

    public int pathCount(Set<Friend> visited, Friend friend, int pathCount) {
        visited.add(friend);
        if (friend.email.equals(email)) {
            pathCount ++;
        } else {
            for(Friend friend1: friend.getFriends()) {
                if(!visited.contains(friend1)) {
                    pathCount = pathCount(visited, friend1, pathCount);
                }
            }
        }

        visited.remove(friend);
        return pathCount;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
}