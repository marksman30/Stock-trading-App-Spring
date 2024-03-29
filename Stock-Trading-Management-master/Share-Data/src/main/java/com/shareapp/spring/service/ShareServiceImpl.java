
package com.shareapp.spring.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shareapp.spring.dao.ShareRepository;
import com.shareapp.spring.model.Share;

@Transactional
@Service("shareService")
public class ShareServiceImpl implements ShareService {
	
	@Autowired
	private ShareRepository shareRepository;
	
	@Override
	public Iterable<Share> findAll() {
		return shareRepository.findAll();
				
	}

	@Override
	public Optional<Share> findById(int id) {
		// TODO Auto-generated method stub
		return shareRepository.findById(id);
	}
}