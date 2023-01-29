MACHINEOVERRIDES =. "gagarin-debug:"

OBMC_IMAGE_EXTRA_INSTALL:append = " \
    strace \
    gdbserver \
    screen \
    iproute2 \
    ethtool \
    psmisc \
    tcpdump \
"

#It needs to replace dropebear on openssh to debug with Eclipse 
#OBMC_IMAGE_EXTRA_INSTALL:append = " \                                                                                                                                                                                                         
#    openssh-sftp \
#    openssh-sftp-server \                                                                                                                                                                                                                                  
#"    
#EXTRA_IMAGE_FEATURES:append := " \
#    eclipse-debug \
#    ssh-server-openssh \
#    "

BB_NUMBER_THREADS ?= "8" 
PARALLEL_MAKE ?= "-j 8"
