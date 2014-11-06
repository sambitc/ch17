package com.apress.prospring3.ch17.restful;

import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.apress.prospring3.ch17.domain.Contact;
import com.apress.prospring3.ch17.domain.Contacts;

public class RestfulClientSample {
	private static final String URL_GET_ALL_CONTACTS = "http://localhost:8080/ch17/restful/contact/listdata";
	private static final String URL_GET_CONTACT_BY_ID = "http://localhost:8080/ch17/restful/contact/{id}";
	private static final String URL_CREATE_CONTACT = "http://localhost:8080/ch17/restful/contact/new";
	private static final String URL_UPDATE_CONTACT = "http://localhost:8080/ch17/restful/contact/{id}";
	private static final String URL_DELETE_CONTACT = "http://localhost:8080/ch17/restful/contact/{id}";

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:restful-client-app-context.xml");
		ctx.refresh();
		Contacts contacts;
		Contact contact;
		RestTemplate restTemplate = ctx.getBean("restTemplate",
				RestTemplate.class);

		// Test retrieve all contacts
		System.out.println("Testing retrieve all contacts:");
		contacts = restTemplate.getForObject(URL_GET_ALL_CONTACTS,
				Contacts.class);
		listContacts(contacts);

		// Retrive contacts with id 1.
		System.out.println("Testing retrieve contats with ID 1 : ");
		contact = restTemplate.getForObject(URL_GET_CONTACT_BY_ID,
				Contact.class, 1);
		System.out.println(contact);

		// Create contact.
		System.out.println("creating new contact---");

		Contact newContact = new Contact();
		newContact.setFirstName("Sambit3");
		newContact.setLastName("choudhury3");
		newContact.setVersion(2);
		newContact.setBirthDate(new DateTime());

		Contact createdContact = restTemplate.postForObject(URL_CREATE_CONTACT,
				newContact, Contact.class);
		System.out.println(createdContact);

		// Test update contact
		contact = restTemplate.getForObject(URL_UPDATE_CONTACT, Contact.class,
				1);
		contact.setFirstName("Kim Fung");
		System.out.println("Testing update contact by id :");
		restTemplate.put(URL_UPDATE_CONTACT, contact, 1);
		System.out.println("Contact update successfully: " + contact);
		System.out.println("");

	}

	private static void listContacts(Contacts contacts) {
		for (Contact contact : contacts.getContacts()) {
			System.out.println(contact);
		}
		System.out.println("");
	}
}