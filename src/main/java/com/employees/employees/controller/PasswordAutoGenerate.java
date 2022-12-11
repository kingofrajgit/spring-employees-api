package com.employees.employees.controller;
//import java.util.Random;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.employees.employees.dto.MessageDTO;

//@RestController
public class PasswordAutoGenerate {
//	@Autowierd
//	userRepository repository;
//	
//	
//	
//	@GetMapping("name")
//	public static ResponseEntity<?> autoGerate(@RequestParam("specification") String specification) {
//		String name = new String(getUserName());
//		name = "kvcet"+specification+name;
//		String password = new String(generatePassword());
//		try {
//			User user = new User();
//			user.setName(name);
//			user.setPassword(password);
//			repository.save(user);
//			sendMail(user);
//			MessageDTO message = new MessageDTO("success");
//			return new ResponseEntity<>(message.getMessage(),HttpStatus.BAD_REQUEST);
//		}catch(Exception e) {
//			
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//		}
//		
//	}
//
//	private static char[] getUserName() {
//		int len = 4;
//		String numbers = "1234567890";
//		 String combinedChars =  numbers;
//		 Random random = new Random();
//	      char[] name = new char[len];
//	      name[0] = numbers.charAt(random.nextInt(numbers.length()));
//	      name[1] = numbers.charAt(random.nextInt(numbers.length()));
//	      name[2] = numbers.charAt(random.nextInt(numbers.length()));
//	      name[3] = numbers.charAt(random.nextInt(numbers.length()));
//	      for(int i = 4; i< len ; i++) {
//		         name[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
//		      }
//		      return name;
//	}
//
//	private static char[] generatePassword() {
//		int length = 6;
//		 String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
//	      String specialCharacters = "!@#$";
//	      String numbers = "1234567890";
//	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
//	      Random random = new Random();
//	      char[] password = new char[length];
//
//	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
//	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
//	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
//	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
//	   
//	      for(int i = 4; i< length ; i++) {
//	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
//	      }
//	      return password;
//	   }

}
