// Generated by `wit-bindgen` 0.26.0. DO NOT EDIT!
package wit.worlds;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.teavm.interop.Memory;
import org.teavm.interop.Address;
import org.teavm.interop.Import;
import org.teavm.interop.Export;
import org.teavm.interop.CustomSection;

public final class ProcessV0{
    private ProcessV0() {}

    @Export(name = "init")
    public static void wasmExportInit(int p0, int p1) {

        byte[] bytes = new byte[p1];
        Memory.getBytes(org.teavm.interop.Address.fromInt(p0), bytes, 0, p1);

        wit.worlds.ProcessV0Impl.init(new String(bytes, StandardCharsets.UTF_8));

    }

    @CustomSection(name = "component-type:ProcessV0")
    private static final String __WIT_BINDGEN_COMPONENT_TYPE = "0061736d0d0001000019167769742d636f6d706f6e656e742d656e636f64696e67040007df0a01410201410401425001730400046a736f6e03000001730400076e6f64652d696403000201707d040007636f6e746578740300040172030c70726f636573732d6e616d65730c7061636b6167652d6e616d65730e7075626c69736865722d6e6f64650304000a70726f636573732d69640300060172020c7061636b6167652d6e616d65730e7075626c69736865722d6e6f64650304000a7061636b6167652d6964030008017202046e6f6465030770726f63657373070400076164647265737303000a016b7301707d017202046d696d650c0562797465730d04000e6c617a792d6c6f61642d626c6f6203000e017202066973737565720b06706172616d730104000a6361706162696c697479030010016b77016b0101701101720507696e68657269747f10657870656374732d726573706f6e73651204626f64790d086d65746164617461130c6361706162696c6974696573140400077265717565737403001501720407696e68657269747f04626f64790d086d65746164617461130c6361706162696c697469657314040008726573706f6e7365030017016b05016f021819017102077265717565737401160008726573706f6e7365011a000400076d65737361676503001b016b0f016f030b161d01701e017103046e6f6e65000007726573746172740000087265717565737473011f000400076f6e2d65786974030020016d02076f66666c696e650774696d656f757404000f73656e642d6572726f722d6b696e64030022017204046b696e6423067461726765740b076d6573736167651c0e6c617a792d6c6f61642d626c6f621d04000a73656e642d6572726f72030024016d020a6e616d652d74616b656e0f6e6f2d66696c652d61742d7061746804000b737061776e2d6572726f7203002601400209766572626f736974797d076d6573736167657301000400117072696e742d746f2d7465726d696e616c0128014001076f6e2d6578697421010004000b7365742d6f6e2d657869740129014000002104000b6765742d6f6e2d65786974012a016b0d014000002b0400096765742d7374617465012c0140010562797465730d01000400097365742d7374617465012d014000010004000b636c6561722d7374617465012e017007016a01070127014006046e616d650c097761736d2d7061746873076f6e2d657869742114726571756573742d6361706162696c697469657314126772616e742d6361706162696c69746965732f067075626c69637f0030040005737061776e01310140010463617073140100040011736176652d6361706162696c6974696573013204001164726f702d6361706162696c6974696573013201400000140400106f75722d6361706162696c69746965730133016f020b1c016f022519016a013401350140000036040007726563656976650137014000001d0400086765742d626c6f620138014004067461726765740b07726571756573741607636f6e74657874190e6c617a792d6c6f61642d626c6f621d010004000c73656e642d726571756573740139016f040b16191d01703a0140010872657175657374733b010004000d73656e642d7265717565737473013c01400208726573706f6e7365180e6c617a792d6c6f61642d626c6f621d010004000d73656e642d726573706f6e7365013d016a01340125014003067461726765740b0772657175657374160e6c617a792d6c6f61642d626c6f621d003e04001773656e642d616e642d61776169742d726573706f6e7365013f03011d6b696e6f64653a70726f636573732f7374616e6461726440302e382e300500014001036f7572730100040004696e6974010104011f6b696e6f64653a70726f636573732f70726f636573732d763040302e382e3004000b1001000a70726f636573732d7630030000004d0970726f647563657273010c70726f6365737365642d6279020d7769742d636f6d706f6e656e7407302e3230392e31167769742d62696e6467656e2d746561766d2d6a61766106302e32362e30";

    public static final class Tuple3<T0, T1, T2>{
        public final T0 f0;
        public final T1 f1;
        public final T2 f2;

        public Tuple3(T0 f0, T1 f1, T2 f2) {
            this.f0 = f0;
            this.f1 = f1;
            this.f2 = f2;
        }

    }

    public static final class Tuple2<T0, T1>{
        public final T0 f0;
        public final T1 f1;

        public Tuple2(T0 f0, T1 f1) {
            this.f0 = f0;
            this.f1 = f1;
        }

    }

    public static final class Tuple4<T0, T1, T2, T3>{
        public final T0 f0;
        public final T1 f1;
        public final T2 f2;
        public final T3 f3;

        public Tuple4(T0 f0, T1 f1, T2 f2, T3 f3) {
            this.f0 = f0;
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
        }

    }

    public static final class Result<Ok, Err> {
        public final byte tag;
        private final Object value;

        private Result(byte tag, Object value) {
            this.tag = tag;
            this.value = value;
        }

        public static <Ok, Err> Result<Ok, Err> ok(Ok ok) {
            return new Result<>(OK, ok);
        }

        public static <Ok, Err> Result<Ok, Err> err(Err err) {
            return new Result<>(ERR, err);
        }

        public Ok getOk() {
            if (this.tag == OK) {
                return (Ok) this.value;
            } else {
                throw new RuntimeException("expected OK, got " + this.tag);
            }
        }

        public Err getErr() {
            if (this.tag == ERR) {
                return (Err) this.value;
            } else {
                throw new RuntimeException("expected ERR, got " + this.tag);
            }
        }

        public static final byte OK = 0;
        public static final byte ERR = 1;
    }

    public static final class Cleanup {
        public final int address;
        public final int size;
        public final int align;

        public Cleanup(int address, int size, int align) {
            this.address = address;
            this.size = size;
            this.align = align;
        }
    }
    public static final int RETURN_AREA = Memory.malloc(152, 8).toInt();
}
