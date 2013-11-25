The OpenShift `jbosseap` cartridge documentation can be found at:

https://github.com/openshift/origin-server/tree/master/cartridges/openshift-origin-cartridge-jbosseap/README.md

Create an boss application using :


rhc create-app testsendmail jbossas-7 --from-code=git@github.com:nikhilmone/sendmail.git

same application should work for jbosseap-6, jbossews-1.0 and jbossews-2.0 cartridges as well. Do remember to change
sender/receiver mailID and password in "SendFromYahoo.java", tweak a little more if you want to then 
git add > commit > push the application.
