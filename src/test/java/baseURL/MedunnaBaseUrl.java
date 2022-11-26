package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.Authentication;

public class MedunnaBaseUrl extends Authentication{

    protected RequestSpecification spec;


    @Before
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://www.medunna.com/api/").build();


        //spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

    }
}
/*
*** restassured kütüphanesinin sağladığı RequestSpecification data tipini kullanarak,
    bace url i atayacapımız instance (spec) tanımlıyoruz.

*** Acces modifier'i protected olarak belirliyoruz. Farklı package'ın altındaki class lardan, oluşturduğumuz baceUrl
    class'ına extende yaparak inheritance (child/class) ilişkisi oluşturarak hazırladığımız verilere erişmesini sağlıyoruz.

*** JUnit in sağladığı Before annotation ile method oluşturarak her test'ten once çalışmasını sağlayacağız.
    * RequestSpecification ==> interface olduğundan, interface lerden obje oluşturulamaz.
    * Bu sebeple RequestSpecification in bir constructor'ı yoktur.
    * restassured kütüphanesinin sağladığı, RequestSpecBuilder() isimli class'ın constructor'ını kullanarak,
    * setBaseUri() methodunu çağırıp, sonuna da build() methodunu ekleyerek spec'in atamasını gerçekleştiriyoruz.
 */
