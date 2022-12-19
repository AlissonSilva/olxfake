### Projeto OLX Fake

Projeto Kotlin e Laravel 8: OLX Fake 


#### Server 

Verificar na estrutura do arquivo .env 

DB_CONNECTION=mysql <br>
DB_HOST=127.0.0.1 <br>
DB_PORT=3306 <br>
DB_DATABASE=olxfake <br>
DB_USERNAME=root <br>
DB_PASSWORD= <br>

Após configuração do arquivo .env, executar os comando abaixo.

<b>composer install</b><br>
<b>php artisan migrate</b><br>
<b>php artisan serve</b>

<b>Estrutura da API</b>

<b>GET</b>: /api/anuncios/listar <br>
<b>POST</b>: /api/anuncios/store <br>
<b>GET</b>: /api/categorias/listar <br>
<b>POST</b>: /api/categorias/store <br>

#### Aplicativo

Verificar no arquivo <b>olxfake\api\ApiService.kt</b> o retorno do Retrofit, configurar o end point correto.

return Retrofit.Builder()<br>
            .baseUrl("http://192.168.56.1:8000/")<br>
            .addConverterFactory(GsonConverterFactory.create())<br>
            .client(client)<br>
            .build()<br>
            
 ### Screenshot
 
 ![''](to_readme/img1.jpg)
 
 ![](to_readme/img2.jpg)
 
 ![](to_readme/img3.jpg)
 
 ![](to_readme/img4.jpg)
 
 ![](to_readme/img5.jpg)
