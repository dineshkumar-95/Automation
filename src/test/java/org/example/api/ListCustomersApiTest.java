package org.example.api;

import io.restassured.path.json.JsonPath;
import org.example.BaseTest;
import org.example.api.models.request.ListCustomersApiRequest;
import org.example.api.models.response.Customer;
import org.example.api.models.response.common.Card;
import org.example.api.models.response.wrappers.ChargebeeListResponse;
import org.example.api.utils.ApiResponseUtils;
import org.testng.annotations.Test;

public class ListCustomersApiTest extends BaseTest {

    @Test(description = "Verify fluent request.id().startsWith() parent-chaining syntax")
    public void testFluentChainingSyntax() {
//        ListCustomersRequest request = new ListCustomersRequest()
//                .id().startsWith("cust_")
//                .email().is("test@example.com")
//                .createdAt().after(1700000000L)
//                .setLimit(10)
//                .setSortByDesc("created_at");
        ListCustomersApiRequest request = new ListCustomersApiRequest()
                .setLimit(1)
//                .setSortByDesc("created_at")
                .setSortBy().setDesc("created_at")
//                .setId().startsWith("cust_")
                ;

        ChargebeeListResponse responses = ApiResponseUtils.parseList(customerApi.listCustomersApi(request));
        Customer customer = responses.getCustomers().get(0);
        Card card = responses.getCards().get(0);
        System.out.println("********Customer id ********");
        System.out.println(customer.getId());
        System.out.println("********Card Type********");
        System.out.println(card.getCardType());

        JsonPath jsonPath = customerApi.listCustomersApi(request).jsonPath();
        String id = jsonPath.getString("list[0].customer.id");
        System.out.println("********jsonPath  Customer id 0  ********");
        System.out.println(id);

        
    }

}
