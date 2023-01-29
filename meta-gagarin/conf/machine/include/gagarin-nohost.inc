MACHINEOVERRIDES =. "gagarin-nohost:"

require conf/machine/include/gagarin.inc

IMAGE_FEATURES:remove = "obmc-system-mgmt"
IMAGE_FEATURES:remove = "obmc-ikvm"