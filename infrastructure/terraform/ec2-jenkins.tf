# ec2-jenkins.tf
resource "aws_instance" "jenkins" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = "t3.medium"
  vpc_security_group_ids = [aws_security_group.jenkins_sg.id]
  key_name      = "jenkins-key"
  tags = {
    Name = "JenkinsController"
  }
}
