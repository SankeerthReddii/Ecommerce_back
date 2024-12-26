package com.sankeerth.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sankeerth.Service.SankeerthService;
import com.sankeerth.model.Earphones;
import com.sankeerth.model.Laptops;
import com.sankeerth.model.Login;
import com.sankeerth.model.Mobiles;
import com.sankeerth.model.Pods;
import com.sankeerth.model.Smart;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("*")
public class SankeerthController {

	@Autowired
	private SankeerthService sankeerthService;
	
	@GetMapping("/laptops")
	public List<Laptops>allLaptops(){
		return sankeerthService.getAllLaptops();
	}
	@GetMapping("/mobiles")
	public List<Mobiles>allMobiles() {
		return sankeerthService.getAllMobiles();
	}
	@GetMapping("/earphones")
	public List<Earphones>allEarphones(){
		return sankeerthService.getAllEarphones();
	}
	@GetMapping("/laptops/{pid}")
	public Optional<Laptops> getlaptopById(@PathVariable int pid) {
		return sankeerthService.getSinglelaptop(pid);
	}
	@GetMapping("/mobiles/{pid}")
	public Optional<Mobiles> getmobileById(@PathVariable int pid) {
		return sankeerthService.getSinglemobile(pid);
	}
	@GetMapping("/earphones/{pid}")
	public Optional<Earphones> getearphoneById(@PathVariable int pid) {
		return sankeerthService.getSingleearphone(pid);
	}
	@GetMapping("/smart")
	public List<Smart>allsmart(){
		return sankeerthService.getAllSmart();
	}
	@GetMapping("/smart/{pid}")
	public Optional<Smart> getsmartById(@PathVariable int pid) {
		return sankeerthService.getSinglesmart(pid);
	}
	@GetMapping("/pods")
	public List<Pods>allpods(){
		return sankeerthService.getAllPods();
	}
	@GetMapping("/pods/{pid}")
	public Optional<Pods> getpodsById(@PathVariable int pid) {
		return sankeerthService.getSinglePods(pid);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login_fn(@RequestBody Login log){
		Optional<Login> Login = sankeerthService.Login(log.getUsername());
		
		HashMap<String,String> response = new HashMap<>();
		if(Login.isPresent() && Login.get().getPassword().equals(log.getPassword())) {
			response.put("login", "success");
		}else {
			response.put("login", "Failed");
		}
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> data) {
        try {
            int amount = (int) data.get("amount");
            String currency = (String) data.get("currency");
            String receipt = (String) data.get("receipt");

            String order = sankeerthService.createOrder(amount, currency, receipt);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create order");
        }
    }
	@PostMapping("/verify-payment")
    public ResponseEntity<?> verifyPayment(@RequestBody Map<String, String> data) {
        String orderId = data.get("razorpay_order_id");
        String paymentId = data.get("razorpay_payment_id");
        String signature = data.get("razorpay_signature");

        boolean isValid = sankeerthService.verifyPayment(orderId, paymentId, signature);

        if (isValid) {
            return ResponseEntity.ok("Payment Verified");
        } else {
            return ResponseEntity.badRequest().body("Payment Verification Failed");
        }
    }
	
	
	
}
