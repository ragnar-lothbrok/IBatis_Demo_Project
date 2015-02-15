import com.billing.dao.CustomerDAO;
import com.billing.model.Customer;


public class TestClass {
    
    public static void main(String[] args) {
        
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer();
        customer.setFirstName("Raghunandan");
        customer.setLastName("Gupta");
        customer.setMobileNo("7276507039");
        customerDAO.insertCustomer(customer);
        
        System.out.println(customerDAO.selectAllCustomers());
        
    }
    
}
