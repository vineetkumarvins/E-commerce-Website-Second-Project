package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;
import com.niit.model.Friend;

@Repository
@Transactional
public class FriendDaoImpl implements FriendDao{
   @Autowired
private SessionFactory sessionFactory;
	public List<User> getListOfSuggestedUsers(String username) {
	    Session session=sessionFactory.getCurrentSession();
	    String queryString="select * from user_batch5 where username in (select username from user_batch5 where username!=? minus (select fromId from friend_batch5 where toId=? and status!='D' union select toId from friend_batch5 where fromId=? and status!='D'))" ;
		SQLQuery query=session.createSQLQuery(queryString);
		query.setString(0, username);
		query.setString(1, username);
		query.setString(2, username);
		query.addEntity(User.class);
		List<User> suggestedUsers=query.list();
		return suggestedUsers;
	}

	public void addFriendRequest(String username, String toId) {
		Session session=sessionFactory.getCurrentSession();
		Friend friend=new Friend();
		// friend request is from "username" to "toId"
		friend.setFromId(username);
		friend.setToId(toId);
		friend.setStatus('P');
		session.save(friend);
		
	}

}
