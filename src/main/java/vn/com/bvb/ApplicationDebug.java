package vn.com.bvb;

import java.util.Collections;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;
import vn.com.bvb.entity.Employee;
import vn.com.bvb.entity.Family;
import vn.com.bvb.repository.EmployeeRepository;

// https://loda.me/articles/jpahuong-dan-onetomany-va-manytoone
// https://techmaster.vn/posts/37549/hibernate-onetomany-manytoone-annotation
@SpringBootApplication
@RequiredArgsConstructor
public class ApplicationDebug implements CommandLineRunner {

	public static void main(String[] args) {
	    SpringApplication.run(ApplicationDebug.class, args);
	}

    // Sử dụng @RequiredArgsConstructor và final để thay cho @Autowired
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Tạo ra đối tượng Address có tham chiếu tới person
        Family family = new Family();
        family.setName("Đặng Thảo Phương");
        family.setBirthday(new Date());
        
        // Tạo ra đối tượng person
        Employee employee = new Employee();
        employee.setFullName("Đặng Lâm Đông");
        
        employee.setFamilies(Collections.singleton(family));
        // Lưu vào db
        // Chúng ta chỉ cần lưu Employee, vì cascade = CascadeType.ALL nên nó sẽ lưu luôn Family.
        employeeRepository.saveAndFlush(employee);


        // Vào:http://localhost:8080/h2-console/ để xem dữ liệu đã insert

        /*personRepository.findAll().forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getAddress());
        });*/

    }
}
//output:
// 2
// loda
// Address(id=1, city=Hanoi, province=null)
// Chúng ta đã có thể gọi trực tiếp address trong person sau khi query