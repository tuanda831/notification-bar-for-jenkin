import * as React from "react";
import { useEffect, useState } from "react";
import axios from 'axios';
import "./style.css";


const dataSourceUrl = "https://raw.githubusercontent.com/tuanda831/notification-bar-for-jenkin/main/data.json";

export interface IMetaData {
    link: string;
}

export interface INotification {
    id: string;
    type: number;
    message: string;
    metadata: IMetaData;
}

export interface IManifest {
    notification: INotification[],
}

const onLinkClick = (id: string) => () => {
    localStorage.setItem(id, "existed");
}

const BarComponent = () => {
    const [data, setData] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const { data: response } = await axios.get<IManifest>(dataSourceUrl);
                console.log(response?.notification);
                const notification = (response?.notification).reduce((prv, cur) => {
                    if (localStorage.getItem(cur?.id) !== null) {
                        console.log("1:", prv);
                        return prv;
                    }

                    if (prv === null || prv?.type > cur?.type) {
                        console.log("2:", cur);
                        return cur;
                    }

                    console.log("3:", prv);
                    return prv;
                }, null);

                setData(notification);
            } catch (error) {
                console.error(error.message);
            }
        }

        fetchData();
    }, []);

    return data && <div className="redBar">
        Package Name: {data.message} <a target="_blank" href={data.metadata?.link} onClick={onLinkClick(data.id)}>More Detail</a>
    </div>;
}

export default BarComponent;