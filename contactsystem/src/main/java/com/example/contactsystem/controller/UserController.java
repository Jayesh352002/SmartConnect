package com.example.contactsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contactsystem.dto.ContactDTO;
import com.example.contactsystem.dto.UserDTO;
import com.example.contactsystem.dto.UserLoginDTO;
import com.example.contactsystem.entity.Contact;
import com.example.contactsystem.entity.User;
import com.example.contactsystem.repo.UserRepo;
import com.example.contactsystem.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepo userRepo ; 
	
	@Autowired
	private UserService userService ; 
	
	public Long userId ; 
	
	private String email ; 
	
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
		
	@PostMapping(path = "/saveuser")
	public Long saveUserData(@RequestBody UserDTO userDTO , HttpServletRequest request , HttpSession session, Model model)
	{
		this.userId = userService.addUsers(userDTO);
		session = request.getSession();
	
		System.out.print("Session is Not Empty");
		session.setAttribute("userId", this.userId);
		model.addAttribute("message", "Data Added");
		
		return userId ; 
	}
	
	@PostMapping(path = "/loginusers")
	public String loginUser(@RequestBody UserLoginDTO userLoginDTO)
	{
		String msg = userService.loginUsers(userLoginDTO);
		this.email = msg ; 
        return msg;
	}
	
	@PostMapping(path = "/addcontact")
	public String addContact(@RequestBody ContactDTO contactDTO , Contact contact ,HttpSession session, Model model)
	{
		/*
		String name = principal.getName();
		
		User user = this.userRepo.getUserByUserName(name);
		
		contact.setUser(user);
		
		user.getContacts().add(contact);
		
		this.userRepo.save(user);
		*/
		
		String no = userService.addUserContacts(contactDTO);
		
		//Long id = (Long) session.getAttribute("userId");
		
		//System.out.print("User ID : "+this.userId + "  " + id);
		
		return no;
	}
	
	@GetMapping(path = "/getcontact")
	public List<Contact> getAllContacts()
	{
		
		List<Contact> empty = new ArrayList<Contact>();
		
		try {
			List<Contact> contacts = userService.getAllContactsById(this.userId);
			
			if(contacts!=null) {
				return contacts;
			}
			else
			{
				return empty;
			}
			
		}
		catch(Exception e)
		{
			System.out.print("Exception Occures : "+e);
			return empty;
		}
		
		
	}
	
	@GetMapping(path = "/updatecontact/{Conid}")
	public Contact updateContactData(@PathVariable long Conid)
	{
		Contact con = userService.getContacts(Conid);
		return con ; 
	}
	
	@PostMapping(path = "/updatecontact/{Conid}")
	public String updateData(@RequestBody ContactDTO contactDTO , @PathVariable long Conid)
	{
		return userService.updateData(contactDTO,Conid);
	}
	
	@DeleteMapping(path = "/updatecontact/{Conid}")
	public String deleteData(@PathVariable long Conid)
	{
		userService.deleteData(Conid);
		return "Success";
	}
}
