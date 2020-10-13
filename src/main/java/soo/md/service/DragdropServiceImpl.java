package soo.md.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import soo.md.filesetting.Path;

@Service
public class DragdropServiceImpl implements DragdropService {
	private MultipartHttpServletRequest multipartRequest;
	private Map<String, List<String>> map;
	private String fileStore = Path.FILE_STORE;
	
	@Override
	public MultipartHttpServletRequest getMultipartRequest() {
		return multipartRequest;
	}
	@Override
	public void setMultipartRequest(MultipartHttpServletRequest multipartRequest) {
		this.multipartRequest = multipartRequest;
	}
	
	@Override
	public Map<String, List<String>> getUpdateFileName() {
		upload();
		return map;
	}
    private void upload() {
    	map = new Hashtable<String, List<String>>();
    	
    	Iterator<String> itr = multipartRequest.getFileNames();
    	List<String> ofnames = new ArrayList<String>();
    	List<String> savefnames = new ArrayList<String>();
    	StringBuilder sb = null;
    	while(itr.hasNext()) {
    		sb = new StringBuilder();
    		MultipartFile mpf = multipartRequest.getFile(itr.next());
    		String ofname = mpf.getOriginalFilename(); //1 
    		String savefname //2
    		    = sb.append(new SimpleDateFormat("yyyyMMddhhmmss").format(System.currentTimeMillis()))
    		    .append(UUID.randomUUID().toString())
    		    .append(ofname.substring(ofname.lastIndexOf("."))).toString();
    		
    		long fsize = mpf.getSize(); //3
    		
    		String fileFullPath = fileStore + savefname; //4
    		
    		try {
    			mpf.transferTo(new File(fileFullPath)); //upload
    			ofnames.add(ofname);
    			savefnames.add(savefname);
    		}catch(IOException ie) {}				
    	}
    	
    	map.put("ofnames", ofnames);
    	map.put("savefnames", savefnames);
    }
}
