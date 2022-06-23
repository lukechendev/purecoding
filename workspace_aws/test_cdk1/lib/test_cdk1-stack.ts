import { Duration, Stack, StackProps } from 'aws-cdk-lib';
import { Bucket } from 'aws-cdk-lib/aws-s3';
import { Construct } from 'constructs';
// import * as sqs from 'aws-cdk-lib/aws-sqs';

export class TestCdk1Stack extends Stack {
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    // The code that defines your stack goes here

    // example resource
    // const queue = new sqs.Queue(this, 'TestCdk1Queue', {
    //   visibilityTimeout: cdk.Duration.seconds(300)
    // });

    new Bucket(this, "myBucket1", {
      lifecycleRules: [{
        expiration: Duration.days(1)
      }]
    });
  }
}
