import xml.etree.ElementTree as ET
import os
import datetime
from dateutil.parser import parse as dateParse
import numpy as np
from tqdm import tqdm

def open_and_parse_xml(root, filename):
    xml_full_dir = os.path.join(root, filename)
    root = ET.parse(xml_full_dir).getroot()
    return root

if __name__ == "__main__":
    nFile = sum([len(files) for r, d, files in os.walk("./hbaseBugReport")])
    
    nReportTotal = 0;
    nBugReportTotal = 0;
    bugStatus = {}
    resolutionTimeDeltas = []
    resolutionTime = {}
    resolutionTimeInHours = {}
    
    print("Report Processing:")
    for fRoot, dirs, files in os.walk("./hbaseBugReport"):
        for filename in tqdm(files):
            root = open_and_parse_xml(fRoot, filename)
            
            # If report type is bug then increment nBugReportTotal
            for bugElem in root.iter("type"):
                if bugElem.text.lower() == "bug":
                    
                    # Get bug report status (closed, open, fixed ...)
                    for statusElem in root.iter("status"):
                        for resolutionElem in root.iter("resolution"):
                            if bugStatus.get(statusElem.text, None) is None:
                                bugStatus[statusElem.text] = 0
                                    
                            bugStatus[statusElem.text] += 1

                            if statusElem.text.lower() in ["fixed", "closed"] or resolutionElem.text.lower() in ["fixed", "closed"]:
                                rawCreatedTime = next(root.iter("created")).text
                                rawResolvedTime = next(root.iter("resolved")).text
                                
                                createdTime = dateParse(rawCreatedTime)
                                resolvedTime = dateParse(rawResolvedTime)

                                deltaTime = resolvedTime - createdTime
                                
                                resolutionTimeDeltas.append(deltaTime.total_seconds())
                    
                    nBugReportTotal += 1
                
                nReportTotal += 1
    
    resolutionTimeDeltas = np.array(resolutionTimeDeltas)
    
    resolutionTime = {
        "minimum": np.amin(resolutionTimeDeltas),
        "average": np.average(resolutionTimeDeltas),
        "median": np.median(resolutionTimeDeltas),
        "maximum": np.amax(resolutionTimeDeltas)
    }
    
    resolutionTimeInHours = {
        "minimum": np.amin(resolutionTimeDeltas) / 3600.0,
        "average": np.average(resolutionTimeDeltas) / 3600.0,
        "median": np.median(resolutionTimeDeltas) / 3600.0,
        "maximum": np.amax(resolutionTimeDeltas) / 3600.0
    }
    
    print(f"Total number of reports: {nReportTotal}")
    print(f"Total number of bug reports: {nBugReportTotal}")
    print(f"List of bug status: {bugStatus}")
    print(f"Sample of resolution time delta in seconds: {resolutionTimeDeltas}")
    print(f"Statistic of resolution time of reports that are either fixed or closed ...")
    print(f"In seconds: {resolutionTime}")
    print(f"In hours: {resolutionTimeInHours}")
