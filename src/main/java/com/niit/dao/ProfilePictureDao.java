package com.niit.dao;

import com.niit.model.ProfilePicture;

public interface ProfilePictureDao {
void saveProfilePicture(ProfilePicture profilePicture);
void save(ProfilePicture profilePicture); //still not used
ProfilePicture getProfilePicture(String username);
}