package br.com.devdojo.awesome.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devdojo.awesome.error.ResourceNotFoundException;
import br.com.devdojo.awesome.model.Student;
import br.com.devdojo.awesome.repository.StudentRepository;


@RestController
@RequestMapping("students")
public class StudentEndpoint {
	
	private final StudentRepository studentDAO;
	
	@Autowired
	public StudentEndpoint(StudentRepository studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(studentDAO.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
		verifyStudentNotExists(id);
			return new ResponseEntity<>(studentDAO.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/findByName/{name}")
	public ResponseEntity<?> findStudentBydName(@PathVariable String name){
		return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}
	
	@PostMapping
	@Transactional(rollbackFor = Exception.class) // Para tratar exception Checked Ou Retirar o rollback para excepetion Unchecked
	public ResponseEntity<?> save(@Valid @RequestBody Student student){
		studentDAO.save(student);
		student.setId(null);
		studentDAO.save(student);
		/*
		 * if(true) throw new RuntimeException("Test Transaction");
		 * studentDAO.save(student);
		 */
		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		verifyStudentNotExists(id);
		studentDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student){
		verifyStudentNotExists(student.getId());
		studentDAO.save(student);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	private void verifyStudentNotExists(Long id) {
		if(studentDAO.findById(id).isEmpty())
			throw new ResourceNotFoundException("Student not found for ID: " + id);
	}
}

