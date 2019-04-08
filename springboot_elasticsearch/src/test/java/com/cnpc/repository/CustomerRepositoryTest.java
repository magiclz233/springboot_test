package com.cnpc.repository;

import com.cnpc.model.Customer;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomers(){
        for (int i = 0; i < 10 ; i++) {
            customerRepository.save( new Customer
                    ( "magic"+i,"北京"+i,20+i ) );
        }
    }

    @Test
    public void findAll(){
        for (Customer c :
                customerRepository.findAll()) {
            System.out.println(c.toString());
        }
    }

    @Test
    public void deleteALL(){
        customerRepository.deleteAll();
    }
    @Test
    public void deleteByUserName(){
        int count = customerRepository.deleteByUserName( "magic5" );
        if(count == 0){
            System.out.println("删除失败");
        }else {
            System.out.println(count+"~~~成功");
        }
    }

    @Test
    public void findByUserName(){
        Customer customer = customerRepository.findByUserName( "magic5" );
        System.out.println(customer.toString());
        customer.setAddress( "北京555555" );
        customerRepository.save( customer );
        Customer magic5 = customerRepository.findByUserName( "magic5" );
        System.out.println(magic5.toString());
    }

    @Test
    public void findByAddress(){
        for (Customer c :
                customerRepository.findByAddress( "北京" )) {
            System.out.println(c.toString());
        }
    }

    @Test
    public void page1(){
        Sort sort = new Sort( Sort.Direction.DESC,"address.keyword");
        Pageable pageable = PageRequest.of( 0,5,sort );
        Page<Customer> page = customerRepository.findAll( pageable );
        for (Customer c :
                page) {
            System.out.println(c.toString());
        }
    }

    //QueryBulider
    @Test
    public void page2(){
        QueryBuilder query = QueryBuilders.boolQuery()
                .must( QueryBuilders.matchQuery( "address","北京" ) );
        Page<Customer> page = customerRepository.search( query,PageRequest.of( 0,5 ) );
        for (Customer c :
                page) {
            System.out.println(c.toString());
        }
    }
}
