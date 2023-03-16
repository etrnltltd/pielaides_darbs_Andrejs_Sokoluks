package com.example.application;

import java.util.ArrayList;

class CreateNewUserDemo {

    public static void main(String[] args) {

        CreateNewUser user1 = new CreateNewUser(
                "John",
                "Doe",
                "180378-21951",
                "john.doe@gmail.com",
                "958185819124"
        );

        CreateNewUser user2 = new CreateNewUser(
                "Alex",
                "McCalister",
                "210991-12951",
                "alex.mccalister@gmail.com",
                "95815125245"
        );


        ArrayList<CreateNewUser> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);

        for (CreateNewUser user : users) {
            user.getUserInfo();
            System.out.println("");
        }

    }


}
