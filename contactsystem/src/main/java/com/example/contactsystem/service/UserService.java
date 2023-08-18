package com.example.contactsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contactsystem.dto.ContactDTO;
import com.example.contactsystem.dto.UserDTO;
import com.example.contactsystem.dto.UserLoginDTO;
import com.example.contactsystem.entity.Contact;
import com.example.contactsystem.entity.User;
import com.example.contactsystem.repo.ContactRepo;
import com.example.contactsystem.repo.ContactRepository;
import com.example.contactsystem.repo.UserRepo;

@Service
public class UserService {

	private UserRepo userRepo ;

	private ContactRepository contactRepo ; 
	
	private long userId ; 
	
	private String userEmail ; 
	
	@Autowired
	public UserService(UserRepo userRepo, ContactRepository contactRepo) {
		this.userRepo = userRepo;
		this.contactRepo = contactRepo;
	}

	public Long addUsers(UserDTO userDTO)
	{
		User user = new User(
					userDTO.getUserName(),
					userDTO.getUsername(),
					userDTO.getUserEmail(),
					userDTO.getUserPassword());
		
		userRepo.save(user);
		
		this.userId = user.getId();
		
		return userId;
	}
	
	public String addUserContacts(ContactDTO contactDTO) {
		
		Contact con = new Contact(
				contactDTO.getUserName(),
				contactDTO.getNickName(),
				contactDTO.getUserEmail(),
				contactDTO.getUserMobile(),
				contactDTO.getUserWork());
		
		User user = userRepo.getUserByUserId(this.userId);
		
		con.setUser(user);
		
		user.getContacts().add(con);
		
		userRepo.save(user);
		
		return con.getMobile();
	}

	public List<User> getUsers() {
		
		return userRepo.findAll();
	}
	
	public List<Contact> getAllContactsById(long id)
	{
		User user = userRepo.getUserByUserId(this.userId);
		List<Contact> userContacts1 = user.getContacts();
		
		
		if(userContacts1!=null)
		{	
			System.out.print("All Contacts : - "+userContacts1);
			return userContacts1;
		}
		
		return null ;
		
	}
	
	public Contact getContacts(long id)
	{
		Contact cons = contactRepo.getContactByContactId(id);
		return cons ; 
	}
	
	public String updateData(ContactDTO contactDTO , long id)
	{
		
		Optional<Contact> opContact = contactRepo.findById(id);
		
		Contact con = new Contact(
				contactDTO.getUserName(),
				contactDTO.getNickName(),
				contactDTO.getUserEmail(),
				contactDTO.getUserMobile(),
				contactDTO.getUserWork());
		
		
		if(opContact.isPresent()) {
			
			Contact con1 = opContact.get();
			
			con1.setName(con.getName());
			con1.setNickname(con.getNickname());
			con1.setEmail(con.getEmail());
			con1.setMobile(con.getMobile());
			con1.setWork(con.getWork());
			
			contactRepo.save(con1);
			
			return"Success";
		}
		else {
			return "Failure";
		}
	}
	
	public void deleteData(long id)
	{
		contactRepo.deleteById(id);

	}

	public String loginUsers(UserLoginDTO userLoginDTO) {
		
		User user = userRepo.findByEmail(userLoginDTO.getUserEmail());
		
		this.userEmail = userLoginDTO.getUserEmail();
		
		this.userId = user.getId();
		
		if(user!=null)
		{
			String pass1 = userLoginDTO.getUserPassword();
			String pass2 = user.getPassword();
			
			if(pass1.equals(pass2))
			{
				Optional<User> user1 = userRepo.findOneByEmailAndPassword(userLoginDTO.getUserEmail(), pass2);
				
				if(user1.isPresent())
				{
					return this.userEmail;
				}
				else
				{
					return "Login Failed";
				}
			}
			else
			{
				return "Password Does Not Match";
			}
		}
		else
		{
			return "Email Does Not Exists";
		}
		
	}
	
}
