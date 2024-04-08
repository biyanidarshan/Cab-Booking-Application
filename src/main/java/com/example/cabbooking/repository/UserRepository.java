package com.example.cabbooking.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.example.cabbooking.models.User;

@Component
public class UserRepository {
	
	private static ArrayList<User> usersList = new ArrayList<>();

	public ArrayList<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(ArrayList<User> usersList) {
		UserRepository.usersList = usersList;
	}

	public boolean checkUserDetails (User newUser)
    {
        for(User user : usersList)
        {
            if(user.getUserName().equals(newUser.getUserName()) && user.getAge()==newUser.getAge() && user.getUserGender()==newUser.getUserGender() )
                return true;
        }
        return false;
    }
	
	public boolean add_User_Repository(User newUser)
    {
        return usersList.add(newUser);
    }
	
	
}
