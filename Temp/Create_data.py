import random
class dau_annalysis():
    def __init__(self):
        self.data={
            "event_day":[20190301,20190302,201903003,20190304,20190305,20190306],
            'peoduct':['mainline','lite'],
            "os_name":['android','ios'],
            'user_type':['新增','召回','老户'],
            'open_type':['主动打开','有效调起','push','other'],
            'first_action':['搜索','feed','小程序','小说','活动','其他'],
            'is_miniapp':[0,1],
            'is_novel':[0,1],
            'is_invoke':[0,1],
            'is_push':[0,1],
            'is_self_opend':[0,1]
        }
    def out_data(self):
        f=open('./dau.txt','w+')
        for i in range(0,1000):
            out = []
            for e in self.data:
                out.append(str(random.choice(self.data[e])))
            out.append(str(random.randint(1000,100000)))
            out_line=('\t'.join(out))
            out_line+='\n'
            f.write(out_line)
        f.close()

if __name__=='__main__':

    a=dau_annalysis()
    a.out_data()
