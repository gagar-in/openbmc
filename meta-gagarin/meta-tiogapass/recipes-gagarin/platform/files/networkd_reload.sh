#!/bin/bash

#temp fix. BMC doen't get ip eth dhcp after loading
systemctl reload systemd-networkd.service

exit 0;


