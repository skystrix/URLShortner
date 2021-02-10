# URLShortner
## Spring Boot Application for URL Shortner 
 
### API Endpoints:  

**Shorten and add a URL**  
Method: POST  
Data: Long URL as String
http://localhost:8080/url/  
  
**Get all URL information from database**  
Method: GET   
http://localhost:8080/url/all  
  
**Get information about a particuar URL:**      
Method: GET  
http://localhost:8080/url/{id}
  
**See all URL access history:**  
Method: GET   
http://localhost:8080/history/ 
  
