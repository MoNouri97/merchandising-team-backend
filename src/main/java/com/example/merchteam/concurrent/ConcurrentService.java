package com.example.merchteam.concurrent;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcurrentService {
	private final ConcurrentRepository concurrentRepository;
	@Autowired
	public ConcurrentService(ConcurrentRepository concurrentRepository) {
		this.concurrentRepository = concurrentRepository;
	}
	public  List<Concurrent> getConcurrents() {
		return concurrentRepository.findAll();
	}

	public  Concurrent getConcurrentParId(Long concurrentId) {
		return concurrentRepository.findById(concurrentId).orElseThrow(()->new IllegalStateException("concurrent with id"+concurrentId+"does not exist"));

	}

	public  void addConcurrent(Concurrent concurrent) {
		concurrentRepository.save(concurrent);		
	}

	public  void deleteConcurrent(Long concurrentId) {
		boolean exists =concurrentRepository.existsById(concurrentId);
		if(!exists) {
			throw new IllegalStateException("concurrent with id"+concurrentId+"does not exist");
		}
		concurrentRepository.deleteById(concurrentId);		
	}

	public  Concurrent updateConcurrent(Long concurrentId, Concurrent crt) {
		return concurrentRepository.findById(concurrentId).map(concurrent -> {
			if(crt.getName()!=null && crt.getName().length() > 0 && !Objects.equals(concurrent.getName(),crt.getName())) {
				concurrent.setName(crt.getName());
			}
			if(crt.getCategory()!=null && crt.getCategory().length() > 0 && !Objects.equals(concurrent.getCategory(),crt.getCategory())) {
				concurrent.setCategory(crt.getCategory());
			}
			if(crt.getGms()!=null && crt.getGms().length() > 0 && !Objects.equals(concurrent.getGms(),crt.getGms())) {
				concurrent.setGms(crt.getGms());
			}
			return concurrentRepository.save(concurrent);
		}).orElseThrow(()->new IllegalStateException("concurrent with id"+concurrentId+"does not exist"));
		
	}

}
