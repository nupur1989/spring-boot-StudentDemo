    package com.example.springboot.Controller;

    import com.example.springboot.Entity.Student;
    import com.example.springboot.Service.StudentService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.http.HttpRequest;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/")
    public class StudentController {

        @Autowired
        private StudentService studentService;

        public StudentController(){

        }

        //making student id as path variable makes sure it is part of the path and is required.
        @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
        public String getStudent(
                @PathVariable( value ="studentId") Integer studentId){
            return this.studentService.getStudent(studentId);
        }

        //POST
        @RequestMapping( value = "persistStudent", method =  RequestMethod.POST)
        public ResponseEntity <String> createStudent(@RequestBody  Student student){
            if(student.isValid()){
                studentService.createStudent(student);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        //PATCH - used to update few sections of an objwct. lets say you want to update name for stusent
        @RequestMapping( value = "persistStudent", method =  RequestMethod.PUT)
        public ResponseEntity < String > updateStudent(@RequestBody Student student){
            if(student.isValid()){
                studentService.createStudent(student);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
