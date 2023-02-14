# OpenBMC

OpenBMC is a Linux distribution for management controllers used in devices such
as servers, top of rack switches or RAID appliances. It uses
[Yocto](https://www.yoctoproject.org/),
[OpenEmbedded](https://www.openembedded.org/wiki/Main_Page),
[systemd](https://www.freedesktop.org/wiki/Software/systemd/), and
[D-Bus](https://www.freedesktop.org/wiki/Software/dbus/) to allow easy
customization for your platform.

This repository provides early access to GAGAR.IN Computing's BMC implementation for GAGAR.IN's server platform reference designs. It is the intention to submit all features in this repository to the OpenBMC main project (github/openbmc) in due course.

For open questions and support, please contact info@gagarin.me

## Setting up your OpenBMC project

### 1) Prerequisite

See the
[Yocto documentation](https://docs.yoctoproject.org/ref-manual/system-requirements.html#required-packages-for-the-build-host)
for the latest requirements

#### Ubuntu

```sh
sudo apt install git python3-distutils gcc g++ make file wget \
    gawk diffstat bzip2 cpio chrpath zstd lz4 bzip2
```

#### Fedora

```sh
sudo dnf install git python3 gcc g++ gawk which bzip2 chrpath cpio \
    hostname file diffutils diffstat lz4 wget zstd rpcgen patch
```

### 2) Download the source

```sh
git clone https://github.com/gagar-in/openbmc.git
cd openbmc
```

### 3) Target your hardware

Source the setup script and use one of the following for GAGAR.IN's platform:

  - tiogapass

```text
$ . setup gagarin-tp
```

### 4) Build

```sh
bitbake obmc-phosphor-image
```

On successful build, the BMC image will be located in

```sh
tmp/deploy/images/gagarin-tp/
```
Additional details can be found in the [docs](https://github.com/openbmc/docs)
repository.

## Installing BMC firmware

If there is no firmware pre-installed on the system, you will need to program it to the BMC's SPI NOR using an external SPI programmer like Dediprog using obmc-phosphor-image-.static.mtd.

If a previous version of GAGAR.IN's OpenBMC has been installed, perform the following steps to update BMC firmware.

Open new Redfish token:

```sh
$ export token=`curl -k -H "Content-Type: application/json" -X POST https://${BMC_IP}/login -d '{"username" :  "root", "password" :  "0penBmc"}' | grep token | awk '{print $2;}' | tr -d '"'`
```

Use Redfish UpdateService to flash the BMC firmware:

```sh
$ curl -k -H "X-Auth-Token: $token" \
       -H "Content-Type: application/octet-stream" \
       -X POST -T ${BMC_FW}.mtd.tar https://${BMC_IP}/redfish/v1/UpdateService
```
Reboot BMC to start the firmware update:

```sh
$ curl -k -H "X-Auth-Token: $token" \
       -H "Content-Type: application/octet-stream" \
       -X POST -d '{"ResetToDefaultsType":"ResetAll"}' https://${BMC_IP}/redfish/v1/Managers/bmc/Actions/Manager.Reset
```
