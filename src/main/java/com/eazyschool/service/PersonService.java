package com.eazyschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eazyschool.constants.EazySchoolConstants;
import com.eazyschool.model.Person;
import com.eazyschool.model.Roles;
import com.eazyschool.repository.PersonRepository;
import com.eazyschool.repository.RolesRepository;

@Service
public class PersonService {
	
		@Autowired
		private PersonRepository personRepository;
		
		@Autowired
		private RolesRepository rolesRepository;
		
		public boolean createNewPerson(Person person) {
			boolean isSaved = false;
			Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
			person.setRoles(role);
			person = personRepository.save(person);
			if(null!=person && person.getPersonId() >0	) {
				isSaved= true;
			}
			return isSaved;
		}
		

}
