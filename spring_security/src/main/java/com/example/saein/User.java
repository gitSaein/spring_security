package com.example.saein;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class User {

	Long id;
	String userId;
	String password;
	String userRole;
	Date updatedate;
	
}
