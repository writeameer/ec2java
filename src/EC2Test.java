import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.util.Assert;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.auth.*;
import java.util.Map;

public class EC2Test {

	static private AmazonEC2Client ec2Client;
	static private AWSCredentials awsCredentials;
	static Map<String, String> env = System.getenv();
	static private String awsAccessKeyId = env.get("AWS_ACCESS_KEY_ID");
	static private String awsSecretAccessKey  = env.get("AWS_SECRET_ACCESS_KEY");
	
	public EC2Test(){
		 awsCredentials = new BasicAWSCredentials(awsAccessKeyId,awsSecretAccessKey);
		 ec2Client = new AmazonEC2Client(awsCredentials);
	}

	@Test
	public void DescribeInstances() {
		DescribeInstancesRequest request = new DescribeInstancesRequest();
 
		DescribeInstancesResult response = ec2Client.describeInstances(request);
		Assert.notNull(response);
		System.out.println(response.toString());
			
	}
}
