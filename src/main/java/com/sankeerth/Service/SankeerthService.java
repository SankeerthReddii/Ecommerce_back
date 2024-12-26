package com.sankeerth.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankeerth.model.Earphones;
import com.sankeerth.model.Laptops;
import com.sankeerth.model.Login;
import com.sankeerth.model.Mobiles;
import com.sankeerth.model.Pods;
import com.sankeerth.model.Smart;
import com.sankeerth.repo.EarphonesRepo;
import com.sankeerth.repo.LaptopsRepo;
import com.sankeerth.repo.LoginRepo;
import com.sankeerth.repo.MobilesRepo;
import com.sankeerth.repo.PodsRepo;
import com.sankeerth.repo.SmartRepo;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;

@Service
public class SankeerthService {
	@Autowired
	private LaptopsRepo laptopsRepo;
	
	@Autowired
	private MobilesRepo mobilesRepo;
	@Autowired
	private EarphonesRepo earphonesRepo;
	@Autowired
	private LoginRepo loginRepo;
	@Autowired
	private SmartRepo smartrepo;
	@Autowired
	private PodsRepo podsrepo;
	
	public List<Laptops>getAllLaptops(){
		return laptopsRepo.findAll();
	}
	public List<Mobiles> getAllMobiles(){
		return mobilesRepo.findAll();
	}
	public List<Earphones> getAllEarphones(){
		return earphonesRepo.findAll();
	}
	public Optional<Laptops> getSinglelaptop (int pid){
		return laptopsRepo.findById(pid);
	}
	public Optional<Mobiles> getSinglemobile (int pid){
		return mobilesRepo.findById(pid);
	}
	public Optional<Earphones> getSingleearphone (int pid){
		return earphonesRepo.findById(pid);
	}
	public List<Smart> getAllSmart(){
		return smartrepo.findAll();
	}
	public Optional<Smart> getSinglesmart (int pid){
		return smartrepo.findById(pid);
	}
	public List<Pods> getAllPods(){
		return podsrepo.findAll();
	}
	public Optional<Pods> getSinglePods (int pid){
		return podsrepo.findById(pid);
	}
	public Optional<Login> Login(String username){
		return loginRepo.findByusername(username);
	}
	
//	razor pay
	
	 public String createOrder(int amount, String currency, String receipt) throws RazorpayException {
	        RazorpayClient razorpay = new RazorpayClient("rzp_live_0CAWJFt3q8oaUX", "GbtM4BCQJJyyBA4L0NjnwmZV");

	        JSONObject orderRequest = new JSONObject();
	        orderRequest.put("amount", amount * 100); // Amount in paise
	        orderRequest.put("currency", currency);
	        orderRequest.put("receipt", receipt);

	        Order order = razorpay.orders.create(orderRequest);
	        return order.toString();
	    }

	    public boolean verifyPayment(String orderId, String paymentId, String signature) {
	        String generatedSignature = HmacSHA256(orderId + "|" + paymentId, "GbtM4BCQJJyyBA4L0NjnwmZV");
	        return generatedSignature.equals(signature);
	    }

	    private String HmacSHA256(String data, String secret) {
	        try {
	            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
	            mac.init(new javax.crypto.spec.SecretKeySpec(secret.getBytes(), "HmacSHA256"));
	            byte[] hmacData = mac.doFinal(data.getBytes());
	            return javax.xml.bind.DatatypeConverter.printHexBinary(hmacData).toLowerCase();
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to calculate HMAC SHA256", e);
	        }
	
	    }
}
