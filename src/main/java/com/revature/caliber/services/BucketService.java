package com.revature.caliber.services;

import java.util.List;
import io.swagger.annotations.ApiModel;



import com.revature.caliber.beans.Bucket;


/**
 * Interface for our Bucket service layer
 * 
 * @author adil iqbal | 1805-WVU-MAY29 | Richard Orr
 * @author Theo Thompson | 1805-WVU-MAY29 | Richard Orr
 * 
 */
@ApiModel(value = "BucketService", description = "Provides interface for the Bucket service layer")
public interface BucketService {

	/**
	 * creates a new bucket in the DB
	 * @param bucket - a new bucket
	 * @return Bucket obj w/ updated id
	 */
	public Bucket createBucket(Bucket bucket);

	/**
	 * Fetches all buckets
	 * @return list of buckets
	 */
	public List<Bucket> getAllBuckets();
	
	/**
	 * Updates bucket information
	 * @param bucket - bucket to update
	 */
	public void updateBucket(Bucket bucket);
	
	/**
	 * Gets a bucket by its Id
	 * @param bucketId
	 * @return bucket or null if id is not found
	 */
	public Bucket getBucketById(Integer bucketId); 
	
	/**
	 * Removes a bucket with the specified Id
	 * @param bucketId - id of the bucket to be deleted
	 * No return
	 */
	public void deleteBucket(Integer bucketID);

	
		
}